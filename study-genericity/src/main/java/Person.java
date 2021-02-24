public class Person {

    enum Sex{
        MAN("男性"), WOMEN("女性");
        private String description;
        private Sex(String description){
            this.description=description;
        }

        @Override
        public String toString(){
            return description;
        }
    }

    public Person() {
    }
}

