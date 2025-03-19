package lab_1;

class LegalDepartment extends Approver {
    @Override
    protected boolean canApprove(Trouble amount) {
        return amount.getIndex() <= 1000;
    }

    @Override
    protected void approve(Trouble amount) {
        System.out.println("Юридический отдел ответит на ваш вопрос: '" + amount.getText() + "'");
    }
}
