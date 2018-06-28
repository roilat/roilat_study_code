package cn.roilat.study.java.antlr;

public class CalException extends Exception {
    /**  */
    private static final long serialVersionUID = 2191478303845447549L;
    private int    line;
    private int    column;
    private String msg;

    public CalException(int line, int column, String msg) {
        this.line = line;
        this.column = column;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg + ",line:" + line + ",column:" + column;
    }
}
