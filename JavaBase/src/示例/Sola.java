package 示例;

/**
 * @Description 文科生（students of liberal arts）
 */
public class Sola extends Student {
    private String literaryTalent;// 文采

    public Sola() {
    }

    public Sola(String name, int age, byte sex, int grade, String literaryTalent) {
        super(name, age, sex, grade);
        this.literaryTalent = literaryTalent;
    }

    public String getLiteraryTalent() {
        return literaryTalent;
    }

    public void setLiteraryTalent(String literaryTalent) {
        this.literaryTalent = literaryTalent;
    }
}
