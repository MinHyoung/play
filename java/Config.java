public class Config {
    private String option1 = null;
    private boolean option2 = true;
    private int option3 = -1;

    public void validate() throws Exception {
        if (option1 == null) {
            throw new Exception("option1 cannot be null.");
        }
    }

    public String getOption1() {
        return option1;
    }

    public boolean isOption2() {
        return option2;
    }

    public int getOption3() {
        return option3;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(boolean option2) {
        this.option2 = option2;
    }

    public void setOption3(int option3) {
        this.option3 = option3;
    }
}
