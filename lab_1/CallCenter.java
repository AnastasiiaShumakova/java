package lab_1;

class CallCenter extends Approver {
    @Override
    protected boolean canApprove(Trouble amount) {
        return amount.getIndex() <= 10;
    }

    @Override
    protected void approve(Trouble amount) {
        System.out.println("Колл-центр ответит на ваш вопрос: '" + amount.getText() + "'");
    }
}
