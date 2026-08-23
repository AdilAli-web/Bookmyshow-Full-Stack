package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("Beans.xml");

        System.out.println("Singleton Scope Example");
        Student singletonStudent1= context.getBean("singletonStudent",Student.class);
        Student singletonStudent2= context.getBean("singletonStudent",Student.class);

        singletonStudent1.setName("Amit");
        singletonStudent2.showDetails();
        System.out.println("Both singletone object are same : "+ (singletonStudent1==singletonStudent2));

        System.out.println();
        System.out.println("Prototye scope example");
        Student prototypeStudent1= context.getBean("prototypeStudent",Student.class);
        Student prototypeStudent2= context.getBean("prototypeStudent",Student.class);

        prototypeStudent1.setName("Meera");
        prototypeStudent2.setName("Hera");

        prototypeStudent2.showDetails();
        prototypeStudent1.showDetails();

        System.out.println("Both singletone object are same : "+ (prototypeStudent1==prototypeStudent2));
    }
}
