import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Linha_arvore {
    private byte quant_itens;

    private int end_1;
    private Celula celula_1 = new Celula();
    private int end_1_2;

    private Celula celula_2 = new Celula();
    private int end_2_3;

    private Celula celula_3 = new Celula();
    private int end_3_4;

    private Celula celula_4 = new Celula();
    private int end_4;

    Linha_arvore(){
        this.quant_itens = -1;
        this.end_1 = -1;
        this.end_1_2 = -1;
        this.end_2_3 = -1;
        this.end_3_4 = -1;
        this.end_4 = -1;
    }

    void set_quant_itens(byte quant_itens){ this.quant_itens = quant_itens; }

    void set_end_1(int end_1){ this.end_1 = end_1; }
    void set_id_1(int id_1){ this.celula_1.set_id(id_1); }
    void set_end_arq_1(int end_arq_1){ this.celula_1.set_end_arq(end_arq_1); }

    void set_end_1_2(int end_1_2){ this.end_1_2 = end_1_2; }
    void set_id_2(int id_2){ this.celula_2.set_id(id_2); }
    void set_end_arq_2(int end_arq_2){ this.celula_2.set_end_arq(end_arq_2); }

    void set_end_2_3(int end_2_3){ this.end_2_3 = end_2_3; }
    void set_id_3(int id_3){ this.celula_3.set_id(id_3); }
    void set_end_arq_3(int end_arq_3){ this.celula_3.set_end_arq(end_arq_3); }

    void set_end_3_4(int end_3_4){ this.end_3_4 = end_3_4; }
    void set_id_4(int id_4){ this.celula_4.set_id(id_4); }
    void set_end_arq_4(int end_arq_4){ this.celula_4.set_end_arq(end_arq_4); }

    void set_end_4(int end_4){ this.end_4 = end_4; }

    void set_celula_1(Celula celula_1){
        this.celula_1 = celula_1;
    }
    void set_celula_2(Celula celula_2){
        this.celula_2 = celula_2;
    }
    void set_celula_3(Celula celula_3){
        this.celula_3 = celula_3;
    }
    void set_celula_4(Celula celula_4){
        this.celula_4 = celula_4;
    }

    byte get_quant_itens(){ return this.quant_itens; }

    int get_end_1(){ return this.end_1; }
    int get_id_1(){ return this.celula_1.get_id(); }
    int get_end_arq_1(){ return this.celula_1.get_end_arq(); }

    int get_end_1_2(){ return this.end_1_2; }
    int get_id_2(){ return this.celula_2.get_id(); }
    int get_end_arq_2(){ return this.celula_2.get_end_arq(); }

    int get_end_2_3(){ return this.end_2_3; }
    int get_id_3(){ return this.celula_3.get_id(); }
    int get_end_arq_3(){ return this.celula_3.get_end_arq(); }

    int get_end_3_4(){ return this.end_3_4; }
    int get_id_4(){ return this.celula_4.get_id(); }
    int get_end_arq_4(){ return this.celula_4.get_end_arq(); }

    int get_end_4(){ return this.end_4; }

    Celula get_celula_1(){
        return this.celula_1;
    }
    Celula get_celula_2(){
        return this.celula_2;
    }
    Celula get_celula_3(){
        return this.celula_3;
    }
    Celula get_celula_4(){
        return this.celula_4;
    }

    @Override
    public String toString() {
        return "Linha_arvore {" +
                "quant_itens=" + quant_itens +
                ", end_1=" + end_1 +
                ", celula_1={id=" + celula_1.get_id() + ", end_arq=" + celula_1.get_end_arq() + "}" +
                ", end_1_2=" + end_1_2 +
                ", celula_2={id=" + celula_2.get_id() + ", end_arq=" + celula_2.get_end_arq() + "}" +
                ", end_2_3=" + end_2_3 +
                ", celula_3={id=" + celula_3.get_id() + ", end_arq=" + celula_3.get_end_arq() + "}" +
                ", end_3_4=" + end_3_4 +
                ", celula_4={id=" + celula_4.get_id() + ", end_arq=" + celula_4.get_end_arq() + "}" +
                ", end_4=" + end_4 +
                '}';
    }


    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeByte(this.quant_itens);
        dos.writeInt(this.end_1);
        dos.writeInt(this.celula_1.get_id());
        dos.writeInt(this.celula_1.get_end_arq());
        dos.writeInt(this.end_1_2);
        dos.writeInt(this.celula_2.get_id());
        dos.writeInt(this.celula_2.get_end_arq());
        dos.writeInt(this.end_2_3);
        dos.writeInt(this.celula_3.get_id());
        dos.writeInt(this.celula_3.get_end_arq());
        dos.writeInt(this.end_3_4);
        dos.writeInt(this.celula_4.get_id());
        dos.writeInt(this.celula_4.get_end_arq());
        dos.writeInt(this.end_4);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b)throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.quant_itens = dis.readByte();
        this.end_1 = dis.readInt();
        this.celula_1.set_id(dis.readInt());
        this.celula_1.set_end_arq(dis.readInt());
        this.end_1_2 = dis.readInt();
        this.celula_2.set_id(dis.readInt());
        this.celula_2.set_end_arq(dis.readInt());
        this.end_2_3 = dis.readInt();
        this.celula_3.set_id(dis.readInt());
        this.celula_3.set_end_arq(dis.readInt());
        this.end_3_4 = dis.readInt();
        this.celula_4.set_id(dis.readInt());
        this.celula_4.set_end_arq(dis.readInt());
        this.end_4 = dis.readInt();
    }

    Linha_arvore ler_linha(RandomAccessFile arq_arvore)throws IOException{
        Linha_arvore linha_atual = new Linha_arvore();
        byte[] bytes = new byte[53];
        arq_arvore.read(bytes);
        linha_atual.fromByteArray(bytes);
        return linha_atual;
    }

    void adicionar_linha_arquivo(Linha_arvore linha, RandomAccessFile arq_arvore) throws IOException {
        byte[] save = linha.toByteArray();
        arq_arvore.write(save);
    }

    Celula[] ordenar_linha(Celula adicionar, int endereco, RandomAccessFile arq_arvore, Linha_arvore linha_atual){
        Celula vetor[] = new Celula[5];

        vetor[0] = linha_atual.get_celula_1();
        vetor[1] = linha_atual.get_celula_2();
        vetor[2] = linha_atual.get_celula_3();
        vetor[3] = linha_atual.get_celula_4();
        vetor[4] = adicionar;

        Arrays.sort(vetor, (c1, c2) -> {
            if (c1.get_id() == -1) return 1; // Coloca -1 no final
            if (c2.get_id() == -1) return -1; // Coloca -1 no final
            return Integer.compare(c1.get_id(), c2.get_id()); // Ordena IDs positivos
        });

        for (int i = 0; i < 5; i++) {
            //System.out.println("Id: " + vetor[i].get_id() + ", Endereço Arquivo: " + vetor[i].get_end_arq());
        }

        return vetor;
    }

    Linha_arvore preparar_linha(Celula vetor[], Linha_arvore linha_atual){
        Linha_arvore linha = new Linha_arvore();
        linha.set_quant_itens((byte) ((byte)linha_atual.get_quant_itens()+1));
        linha.set_celula_1(vetor[0]);
        linha.set_celula_2(vetor[1]);
        linha.set_celula_3(vetor[2]);
        linha.set_celula_4(vetor[3]);
        return linha;
    }

    Linha_arvore organiza_linha1(Celula[] vetor){
        Linha_arvore linha = new Linha_arvore();

        linha.set_quant_itens((byte)2);
        linha.set_celula_1(vetor[0]);
        linha.set_celula_2(vetor[1]);

        return linha;
    }

    Linha_arvore organiza_linha2(Celula[] vetor){
        Linha_arvore linha = new Linha_arvore();

        linha.set_quant_itens((byte)2);
        linha.set_celula_1(vetor[3]);
        linha.set_celula_2(vetor[4]);

        return linha;
    }

    Linha_arvore preparar_raiz(int end_menor, int end_maior, Celula adicionar){
        Linha_arvore linha = new Linha_arvore();
        linha.set_celula_1(adicionar);
        linha.set_end_1(end_menor);
        linha.set_end_1_2(end_maior);
        linha.set_quant_itens((byte)1);
        return linha;
    }

    void encontrar_pai(int end_menor, int end_maior, Celula adicionar)throws IOException{
        RandomAccessFile arq_arvore = new RandomAccessFile("Arqarvore.db", "rw");
        int raiz = arq_arvore.readInt();
        if(end_menor == raiz || end_maior == raiz){
            Linha_arvore nova_raiz = new Linha_arvore();
            nova_raiz = preparar_raiz(end_menor, end_maior, adicionar);
            int end_raiz = (int)arq_arvore.length();
            arq_arvore.seek(arq_arvore.length());
            System.out.println(arq_arvore.length());
            adicionar_linha_arquivo(nova_raiz, arq_arvore);
            arq_arvore.seek(0);
            arq_arvore.writeInt(end_raiz);
        }
        else{
            while(true){
                System.out.println("teste");
            }
        }
    }

    int endereco_busca(Celula adicionar, int endereco)throws IOException{
        RandomAccessFile arq_arvore = new RandomAccessFile("Arqarvore.db", "rw");
        Linha_arvore linha_atual = new Linha_arvore();
        
        arq_arvore.seek(endereco);
        linha_atual = ler_linha(arq_arvore);
        while (true) {
            if(linha_atual.get_end_1() == -1){
                return endereco;
            }
            else{
                if (adicionar.get_id() < linha_atual.get_end_1()) {
                    endereco = linha_atual.get_end_1();
                }
                else if (adicionar.get_id() < linha_atual.get_end_1_2()){
                    endereco = linha_atual.get_end_1_2();
                }
                else if (adicionar.get_id() < linha_atual.get_end_2_3()){
                    endereco = linha_atual.get_end_2_3();
                }
                else if (adicionar.get_id() < linha_atual.get_end_3_4()){
                    endereco = linha_atual.get_end_3_4();
                }
                else{
                    endereco = linha_atual.get_end_4();
                }
                System.out.println("bora biu: "+endereco);
                arq_arvore.seek(endereco);
                linha_atual = ler_linha(arq_arvore);
            }
        }
    }

    void adicionar_celula(Celula adicionar, int endereco)throws IOException{
        RandomAccessFile arq_arvore = new RandomAccessFile("Arqarvore.db", "rw");
        Linha_arvore linha_atual = new Linha_arvore();
        Celula[] vetor = new Celula[5];
        Celula subir = new Celula();
        int endereco_busca = 0;
        Scanner teclado = new Scanner(System.in);

        arq_arvore.seek(endereco);
        //teclado.nextLine();

        linha_atual = ler_linha(arq_arvore);

        if(linha_atual.get_end_1() == -1){
            vetor = ordenar_linha(adicionar, endereco, arq_arvore, linha_atual);
            if(vetor[4].get_id() == -1){
                arq_arvore.seek(endereco);
                linha_atual = preparar_linha(vetor, linha_atual);
                //System.out.println(linha_atual);
                linha_atual.set_quant_itens((byte) (linha_atual.get_quant_itens()+1));
                adicionar_linha_arquivo(linha_atual, arq_arvore);
            }
            else{
                Linha_arvore linha1 = new Linha_arvore();
                Linha_arvore linha2 = new Linha_arvore();

                linha1 = organiza_linha1(vetor);
                linha2 = organiza_linha2(vetor);
                subir = vetor[2];

                arq_arvore.seek(endereco);
                adicionar_linha_arquivo(linha1, arq_arvore);
                int endereco2 = (int)arq_arvore.length();
                arq_arvore.seek(arq_arvore.length());
                adicionar_linha_arquivo(linha2, arq_arvore);

                encontrar_pai(endereco, endereco2, subir);
            }
        }
        else{
            endereco_busca = endereco_busca(adicionar, endereco);
            adicionar_celula(adicionar, endereco_busca);
        }
        teclado.close();
    }

    void adicionar_arvore(Celula adicionar)throws IOException{
        RandomAccessFile arq_arvore = new RandomAccessFile("Arqarvore.db", "rw");

        if(arq_arvore.length() == arq_arvore.getFilePointer()){
            Linha_arvore linha_raiz = new Linha_arvore();
            arq_arvore.writeInt(4);
            adicionar_linha_arquivo(linha_raiz,arq_arvore);
        }
        arq_arvore.seek(0);
        adicionar_celula(adicionar, arq_arvore.readInt());
    }
}