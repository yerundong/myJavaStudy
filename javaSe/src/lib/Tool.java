package lib;

public class Tool {
    private String name;
    private int year;

    public Tool(String name) {
        this.name = name;
    }

    public Tool(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tool)) return false;

        Tool tool = (Tool) o;

        if (getYear() != tool.getYear()) return false;
        return getName() != null ? getName().equals(tool.getName()) : tool.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getYear();
        return result;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
