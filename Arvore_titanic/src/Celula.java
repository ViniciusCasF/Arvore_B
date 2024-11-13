public class Celula {
    private int id;
    private int end_arq;

    void set_id(int id){ this.id = id; }
    void set_end_arq(int end_arq){ this.end_arq = end_arq; }

    int get_id(){ return this.id; }
    int get_end_arq(){ return this.end_arq; }

    Celula(){
        this.id = -1;
        this.end_arq = -1;
    }
}
