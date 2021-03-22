import javax.naming.spi.DirStateFactory;
import javax.print.attribute.standard.JobKOctets;
import java.util.NoSuchElementException;


public class SparseList<Integer> implements List<Integer> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private int pointer = -1;
    private Object[] array = new Object[INIT_SIZE];
    private int[] spaceArr = new int[INIT_SIZE];
    private int firstSp = 0;

    SparseList(){
    }


    //основні методи, що треба реалізувати

    @Override
    public Integer get(int index){
        if (pointer == 0)
        {
            Object tmp = 0;
            return (Integer) tmp;
        }
        index -= firstSp;
        if (index < 0){
            Object tmp = 0;
            return (Integer) tmp;
        }
        else if (index == 0){
            return (Integer) array[0];
        }
        else{
            int j = 0;
            while (index > 0 && j <= pointer){
                index -= (spaceArr[j] + 1);
                j++;
            }
            if (index != 0)
            {
                Object tmp = 0;
                return (Integer) tmp;
            }
            else {
                return (Integer) array[j];
            }
        }
    }

    @Override
    public void remove(int index){
        if (pointer != -1){
            index -= firstSp;
            if (index < 0){
                firstSp--;
            }
            else if (index == 0){
                firstSp += spaceArr[0];
                for (int i = 0; i < pointer; i++){
                    array[i] = array[i+1];
                    spaceArr[i] = spaceArr[i+1];
                }
                array[pointer] = null;
                spaceArr[pointer] = 0;
                pointer--;
                if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
                    resize(array.length/2);
                    resizeSp(spaceArr.length/2);
                }
            }
            else{
                int j = 0;
                while (index > 0 && j <= pointer){
                    index -= (spaceArr[j] + 1);
                    j++;
                }
                if (index < 0)
                {
                    spaceArr[j-1]--;
                }
                else if (index == 0){
                    spaceArr[j-1] += spaceArr[j];
                    for (int i = j; i < pointer; i++){
                        array[i] = array[i+1];
                        spaceArr[i] = spaceArr[i+1];
                    }
                    array[pointer] = null;
                    spaceArr[pointer] = 0;
                    pointer--;
                    if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
                        resize(array.length/2);
                        resizeSp(spaceArr.length/2);
                    }
                }
            }
        }
    }

    @Override
    public void set(int index, Integer value){
        if ((int) value == 0)
            return;
        if (pointer == array.length-2){
            resize(array.length*2);
            resizeSp(spaceArr.length*2);
        }
       if (pointer == -1){
           array[0] = value;
           firstSp = index;
           spaceArr[0] = 0;
           pointer++;
       }
       else{
           index -= firstSp;
           if (index < 0){
               for (int i = pointer + 1; i > 0; i--){
                   array[i] = array[i-1];
                   spaceArr[i] = spaceArr[i-1];
               }
               array[0] = value;
               spaceArr[0] = - index - 1;
               pointer++;
               firstSp = index + firstSp;
           }
           else if (index == 0){
               array[0] = value;
           }
           else{
               int j = 0;
               while (index > 0 && j <= pointer){
                   index -= (spaceArr[j] + 1);
                   j++;
               }
               if (index < 0)
               {
                   j++;
                   for (int i = pointer + 1; i > j; i--){
                       array[i] = array[i-1];
                       spaceArr[i] = spaceArr[i-1];
                   }
                   array[j] = value;
                   spaceArr[j-1] = index + spaceArr[j];
                   spaceArr[j] = - index - 1;
                   pointer++;
               }
               else if (index == 0){
                   array[j] = value;
               }
               else
               {
                   array[j] = value;
                   spaceArr[j-1] = index;
                   spaceArr[j] = 0;
                   pointer++;
               }
           }
       }
    }

    @Override
    public void sort_nonempty(){
        for (int j = 0;j <= pointer;j++) {
                int key = (int) array[j];
                int i = j - 1;
                while (i >= 0 && (int) array[i] > key) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = key;
        }
    }

    //допоміжні методи

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    private void resizeSp(int newLength){
        int[] newArray = new int[newLength];
        System.arraycopy(spaceArr, 0, newArray, 0, pointer);
        spaceArr = newArray;
    }

    @Override
    public String toString(){
        //System.out.println(array[0]);
        StringBuilder str = new StringBuilder("{ ");
        for (int i=0;i<firstSp;i++)
        {
            str.append("0").append(" ");
        }
        for (int i = 0; i <= pointer; i++) {
            str.append(array[i]).append(" ");
            for (int j=0;j<spaceArr[i];j++)
            {
                str.append("0").append(" ");
            }
        }
        str.append("}");
        return str.toString();
    }



}
