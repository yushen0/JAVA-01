package hello;

/**
 * Hello.java
 */
public class Hello {

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 6;

        System.out.println(Operation.ADD.execute(num1, num2, 2));
    }

    public enum Operation {
        ADD("add"), SUB("sub"), MUL("mul"), DIV("div");

        private final String oprate;

        Operation(String oprate) {
            this.oprate = oprate;
        }

        public String getOprate() {
            return oprate;
        }

        /**
         * 四则运算+if+for
         * 根据操作参数进行四则运算的指定次幂结果
         * @param num1
         * @param num2
         * @param pow
         * @return
         */
        public Double execute(int num1, int num2, int pow) {

            double num = 0.0;

            if (this.oprate.equals(ADD.getOprate())) {
                num = (double) num1 + (double) num2;
            }

            if (this.oprate.equals(SUB.getOprate())) {
                num = (double) num1 - (double) num2;
            }

            if (this.oprate.equals(MUL.getOprate())) {
                num = (double) num1 * (double) num2;
            }

            if (this.oprate.equals(DIV.getOprate())) {
                num = (double) num1 / (double) num2;
            }

            double sum = num;

            for (int i = 1; i < pow; i++) {
                sum = sum * num;
            }
            return sum;
        }

    }
}
