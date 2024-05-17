package iut.montreuil.authent.exam;

public class Qcm {

    public static void main(String[] args) {
        Qcm qcm = new Qcm();
        qcm.q1();
        qcm.q7();
    }

    //Qcm1
    private void q1(){
        String str1 = new String("WayToLearnX");
        String str2 = new String("WayToLearnY");
        System.out.println(str1 = str2);
    }

    private void q7(){
        String str1 = new String("Bob");
        String str2 = new String("Ali");
        System.out.println(str1.charAt(0) > str2.charAt(0));
    }
}
