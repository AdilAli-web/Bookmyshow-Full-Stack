package org.example;

public class GannaCar {

    private IEngine eng;

    public GannaCar() {
    }

    public void setEng(IEngine eng) {
        this.eng = eng;
    }

    public void drive()
    {
        eng.start();
    }
}
