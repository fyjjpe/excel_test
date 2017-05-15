package entity;

/**
 * Created by Administrator on 2017/5/14.
 */
public class StuEntity {
    private int id;
    private String name;
    private String sex;
    private int num;

    public StuEntity() {
    }

    public StuEntity(int id, String name, String sex, int num) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuEntity stuEntity = (StuEntity) o;

        return id == stuEntity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "StuEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", num=" + num +
                '}';
    }
}
