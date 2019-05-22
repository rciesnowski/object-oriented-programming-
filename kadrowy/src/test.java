
class A3 {
    A3(int i) {
        System.out.println("A: " + i);
    }
    A3(int i, int j) {
        System.out.println("A: " + i * j);
    }
    A3() {
        System.out.println("A:");
    }
}

class B3 extends A3 {
    B3(int i) {
        System.out.println("B: " + ( i + i ));
    }
    B3(){
        super(3, 4);
        System.out.println("B: " + 6);
    }
}

class C3 extends B3 {
    C3 (int i) {
        System.out.println("C: " + i + i);
    }
}

class Test3 {
    public static void main (String args[]) {
        new C3(3);
    }
}