package hyerim.section10.access.child;

import hyerim.section10.access.parent.Parent;

public class Child extends Parent {
    public void call() {
        publicValue = 1;
        protectedValue = 2;
        //defaultValue = 3;
        //privateValue = 4;

        publicMethod();
        protectedMethod();
        //defaultMethod();
        //privateMethod();

        printParent();
    }
}
