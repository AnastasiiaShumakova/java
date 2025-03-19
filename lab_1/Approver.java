package lab_1;

abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Trouble trouble) {
        if (canApprove(trouble)) {
            approve(trouble);
        } else if (nextApprover != null) {
            nextApprover.processRequest(trouble); // Передача запроса дальше
        } else {
            System.out.println("Ваш запрос слишком сложный: '" + trouble.getText() + "'");
        }
    }

    protected abstract boolean canApprove(Trouble trouble); // Проверка лимита
    protected abstract void approve(Trouble trouble); // Логика одобрения
}
