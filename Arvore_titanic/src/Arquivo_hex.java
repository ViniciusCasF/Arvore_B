import java.io.*;

public class Arquivo_hex {
    private byte lapide;
    private int id;
    private int passageiro_id;
    private byte sobreviveu;
    private byte classe;
    private String nome;
    private String sexo;
    private byte idade;
    private byte irmaos;
   
    private float fare;

    void set_lapide(byte lapide){ this.lapide = lapide; }
    void set_id(int id){
        this.id = id;
    }
    void set_passageiro_id(int passageiro_id){
        this.passageiro_id = passageiro_id;
    }
    void set_sobreviveu(byte sobreviveu){
        this.sobreviveu = sobreviveu;
    }
    void set_classe(byte classe){ this.classe = classe; }
    void set_nome(String nome){ this.nome = nome; }
    void set_sexo(String sexo){ this.sexo = sexo; }
    void set_idade(byte idade){ this.idade = idade; }
    void set_irmaos(byte irmaos){ this.irmaos = irmaos; }
    void set_fare(float fare){ this.fare = fare; }

    byte get_lapide(){ return lapide; }
    int get_id(){ return id; }
    int get_passageiro_id(){ return passageiro_id; }
    byte get_sobreviveu(){ return sobreviveu; }
    byte get_classe(){ return classe; }
    String get_nome(){ return nome; }
    String get_sexo(){ return sexo; }
    byte get_idade(){ return idade; }
    byte get_irmaos(){ return irmaos; }
    float get_fare(){ return fare; }

    public String toString() {
        return "|Id: "+this.id+"|Id do passageiro: "+this.passageiro_id+"|Sobreviveu: "+this.sobreviveu+"|Classe: "+this.classe+
                "|Nome: "+this.nome+"|Sexo: "+this.sexo+"|Idade: "+this.idade+"|Irmãos: "+this.irmaos+"|Fare: "+this.fare;
    }

    public byte[] toByteArray() throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeByte(this.lapide);
        dos.writeInt(this.id);
        dos.writeInt(this.passageiro_id);
        dos.writeByte(this.sobreviveu);
        dos.writeByte(this.classe);
        dos.writeUTF(this.nome);
        dos.writeUTF(this.sexo);
        dos.writeByte(this.idade);
        dos.writeByte(this.irmaos);
        dos.writeFloat(this.fare);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b)throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.lapide = dis.readByte();
        this.id = dis.readInt();
        this.passageiro_id = dis.readInt();
        this.sobreviveu = dis.readByte();
        this.classe = dis.readByte();
        this.nome = dis.readUTF();
        this.sexo = dis.readUTF();
        this.idade = dis.readByte();
        this.irmaos = dis.readByte();
        this.fare = dis.readFloat();
    }

    void salvar_arquivo()throws IOException {
        ArquivoTextoLeitura arq_csv = new ArquivoTextoLeitura("teste.csv");
        RandomAccessFile arq_hex = new RandomAccessFile("Arqhex.db", "rw");

        Linha_arvore arvore = new Linha_arvore();

        Celula parte_linha = new Celula();

        int quant_id=1;

        Arquivo_hex linha = new Arquivo_hex();

        arq_hex.seek(4);

        String dados = arq_csv.ler();
        String divisoes[];

        while (dados!=null){
            divisoes = dados.split(",");

            linha = salvar_na_linha(divisoes, quant_id);

            parte_linha.set_id(quant_id);
            parte_linha.set_end_arq((int)arq_hex.getFilePointer());

            arvore.adicionar_arvore(parte_linha);

            salvar_linha(linha, arq_hex, quant_id);

            dados = arq_csv.ler();
            quant_id++;
        }
        arq_hex.seek(0);
        arq_hex.writeInt(quant_id-1);
    }

    public Arquivo_hex salvar_na_linha(String divisoes[], int quant_id){
        Arquivo_hex linha = new Arquivo_hex();

        linha.set_lapide((byte)1);
        linha.set_id(quant_id);
        linha.set_passageiro_id(Integer.parseInt(divisoes[0]));
        linha.set_sobreviveu(Byte.parseByte(divisoes[1]));
        linha.set_classe(Byte.parseByte(divisoes[2]));
        linha.set_nome(divisoes[3]);
        linha.set_sexo(divisoes[4]);
        try {
            linha.set_idade((byte)Byte.parseByte(divisoes[5]));
        }
        catch (Exception e){
            linha.set_idade((byte) 0);
        }
        linha.set_irmaos(Byte.parseByte(divisoes[6]));
        linha.set_fare(Float.parseFloat(divisoes[7]));

        return linha;
    }

    public void salvar_linha(Arquivo_hex linha, RandomAccessFile arq_hex, int quant_id) throws IOException {
        byte[] save = linha.toByteArray();
        arq_hex.writeInt(save.length);
        arq_hex.write(save);
    }

    public void buscar_linha(int id) throws IOException {
        RandomAccessFile arqHex = new RandomAccessFile("ArqHex.db", "rw");
        Arquivo_hex linha = new Arquivo_hex();
        int tamanho;
        arqHex.seek(4);
        while (true) {
            try{
                tamanho = arqHex.readInt();
                byte bytes[] = new byte[tamanho];
                arqHex.read(bytes);
                linha.fromByteArray(bytes);
                if(id == linha.id) {
                    System.out.println(linha);
                    arqHex.close();
                    return;
                }
            }
            catch (Exception e){
                return;
            }
        }
    }
}