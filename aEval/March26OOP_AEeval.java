package aEval;

public class March26OOP_AEeval
{
    static enum Operator {
        ADD(1),
        DIVIDE(12),
        MULTIPLY(23),
        SUBTRACT(33);
        private int val;
        Operator(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //(2 + 3) * 4
        System.out.println(Operator.values());
        AEBasic two = new AEBasic(2);
        AEBasic three = new AEBasic(3);
        AEBasic four = new AEBasic(4);
        AEComp tpt = new AEComp(Operator.ADD, two, three);

        AEComp tpttf = new AEComp(Operator.MULTIPLY, tpt, four);
        System.out.println(tpttf.eval());

    }

}


/*abstract class AE{
	abstract int eval();
}*/
interface AE{
    int eval();
}
class AEBasic implements AE{ //extends AE{
    int num;
    public AEBasic(int n){
        num = n;
    }
    public int eval()
    {
        return num;
    }
}
class AEComp implements AE
{
    AE left, right;
    March26OOP_AEeval.Operator operator;
    public AEComp(March26OOP_AEeval.Operator op, AE left, AE right){
        operator = op;
        this.left = left;
        this.right = right;
    }
    public int eval() {
        switch(operator) {
            case ADD:
                return left.eval() + right.eval();
            case SUBTRACT:
                return left.eval() - right.eval();
            case MULTIPLY:
                return left.eval() * right.eval();
            case DIVIDE:
                return left.eval() / right.eval();
        }
        return -1; //should not come here
    }
}
