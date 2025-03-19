package lab_1;

class SeniorManager extends Approver {
    @Override
    protected boolean canApprove(Trouble amount) {
        return amount.getIndex() <= 100;
    }

    @Override
    protected void approve(Trouble amount) {
        System.out.println("Старший менеджер ответит на ваш вопрос: '" + amount.getText() + "'");
    }
}