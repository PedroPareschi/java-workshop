package br.com.pareschi;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if((tonerLevel > -1) && (tonerLevel <= 100)) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount){
        if((tonerAmount <= 0) || (tonerAmount > 100)){
            return -1;
        }
        if(tonerAmount + tonerLevel > 100){
            return -1;
        }
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if(duplex){
            pagesToPrint /= 2;
            pagesToPrint += (pages % 2);
            System.out.println("Printing in duplex mode");
        }
        pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
