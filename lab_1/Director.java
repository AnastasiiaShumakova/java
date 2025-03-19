package lab_1;

class Director extends Approver {
    @Override
    protected boolean canApprove(Trouble amount) {
        return amount.getIndex() <= 5000;
    }

    @Override
    protected void approve(Trouble amount) {
        System.out.println("Директор ответит на ваш вопрос: '" + amount.getText() + "'");
    }
}
