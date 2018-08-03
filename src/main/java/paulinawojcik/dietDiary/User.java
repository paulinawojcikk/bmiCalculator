package paulinawojcik.dietDiary;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double weight;
    private double height;

    private float score;


    public float indexBmi() {

        score = (float) (weight/(((height/100)*(height/100))));

        return Math.round(score);
}
    public String info(float score){

        if(score<16){
            return "wygłodzenie"; }
        else if(score>=16 && score<17){
            return "wychudzenie"; }
        else if (score>=17 && score<18.49){
            return "niedowaga"; }
        else if (score>=18.50 && score<24.99){
            return "wartość prawidłowa"; }
        else if (score>=25.00 && score<29.99){
            return "nadwaga"; }
        else if (score>=30 && score<34.99){
            return "I stopień otyłości"; }
        else if (score>=35 && score<39.99){
            return "II stopień otyłości"; }
        else return "III stopień otyłośći";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", score=" + score +
                '}';
    }
}
