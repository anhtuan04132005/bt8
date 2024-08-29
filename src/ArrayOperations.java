import java.util.Scanner;

public class ArrayOperations {
    public static float[] importData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu cua mang:");
        int n = scanner.nextInt();
        float[] arrays = new float[n];
        
        System.out.println("Nhap phan tu mang:");
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }
    public static void printData(float[] arrays) {
        System.out.println("Mang so thuc la:");
        for (float num : arrays) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mang can it nhat 2 phan tu.");
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float num : arrays) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }

        
        return max2;
    }
    public static void deleteOddIntegers(float[] arrays, boolean convertToInteger) {
        if (arrays.length == 0) {
            System.out.println("Mang rong");
            return;
        }
        int writeIndex = 0;
        for (float num : arrays) {
            if (convertToInteger) {
                int intNum = (int) num;
                if (intNum % 2 == 0) {
                    arrays[writeIndex++] = num;
                }
            } else {
                if (num % 2 == 0) {
                    arrays[writeIndex++] = num;
                }
            }
        }
        
        for (int i = writeIndex; i < arrays.length; i++) {
            arrays[i] = 0;
        }
    }

  
    public static void main(String[] args) {
       
        float[] arrays = importData();

     
        printData(arrays);

        try {
            float max2 = findMax2(arrays);
            System.out.println("Gia tri phan tu thu 2 la " + max2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        deleteOddIntegers(arrays, true);
        System.out.println("Mang sau khi xoa so le:");
        printData(arrays);
    }
}

