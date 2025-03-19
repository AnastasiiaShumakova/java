package lab_1;


public class Main {
    public static void main(String[] args) {
        // Создаем обработчиков
        Approver call = new CallCenter();
        Approver senior = new SeniorManager();
        Approver legal = new LegalDepartment();
        Approver director = new Director();

        // Устанавливаем цепочку: call -> senior -> legal ->director
        call.setNextApprover(senior);
        senior.setNextApprover(legal);
        legal.setNextApprover(director);

        Trouble trouble1 = new Trouble("Где находится банк?", 2);
        Trouble trouble2 = new Trouble("Как оформить банковскую карту?", 98);
        Trouble trouble3 = new Trouble("Списались деньги за услугу, на которой я не был", 940);
        Trouble trouble4 = new Trouble("Оформление кредита на сумму, превышающую 10 миллионов", 1502);
        Trouble trouble5 = new Trouble("Почему небо синее?", 6000);

        call.processRequest(trouble1);
        call.processRequest(trouble2);
        call.processRequest(trouble3);
        call.processRequest(trouble4);
        call.processRequest(trouble5);

    }
}


