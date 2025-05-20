package br.edu.ifpb.es.bd.minio;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.nio.file.Paths;

public class MinioProntuario {
    private static final String endpoint = "http://localhost:9000";
    private static final String accessKey = "admin";
    private static final String secretKey = "password";
    private static final String region = Regions.US_EAST_1.getName();
    private final AmazonS3 s3client;

    private static final String NOME_BUCKET_PRONTUARIOS = "prontuario";

    public MinioProntuario() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        this.s3client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region)).withPathStyleAccessEnabled(true).withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
        System.out.println("Cliente MinIO inicializado!");

        garantirExistenciaBucket(NOME_BUCKET_PRONTUARIOS);
    }

    private void garantirExistenciaBucket(String nomeBucket){
        try{
            if (!s3client.doesBucketExistV2(nomeBucket)) {
                s3client.createBucket(nomeBucket);
                System.out.println("Bucket" + nomeBucket + "Criado com sucesso!!!!1");
            } else {
                System.out.println("Bucket" + nomeBucket + "Já existe");
            }
        } catch (SdkClientException e){
            System.err.println("Erro ao verificar/criar bucket:" + nomeBucket + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enviarArquivos(String nomeBucket, String chaveObjetoNoBucket, String caminhoArquivoLocal){
        File arquivoParaEnviar = new File(caminhoArquivoLocal);

        if(!arquivoParaEnviar.exists() || !arquivoParaEnviar.isFile()) {
            System.err.println("Erro: Arquivo local não encontrado ou não é um arquivo válido em: " + caminhoArquivoLocal);
            return;
        }
        try {
            System.out.println("Enviando arquivo '" + arquivoParaEnviar.getName() + "' para o bucket '" + nomeBucket + "' com a chave '" + chaveObjetoNoBucket + "'...");
            PutObjectRequest request = new PutObjectRequest(nomeBucket, chaveObjetoNoBucket, arquivoParaEnviar);
            s3client.putObject(request);
            System.out.println("Arquivo enviado com sucesso!");

        } catch (AmazonServiceException e) {
            System.err.println("Erro do serviço Amazon ao enviar arquivo (verifique permissões, nome do bucket, etc.):");
            e.printStackTrace();
        } catch (SdkClientException e) {
            System.err.println("Erro do cliente SDK ao enviar arquivo (verifique conexão, endpoint, etc.):");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MinioProntuario minioProntuario = new MinioProntuario();
        String nomePastaLocal = "prontuarios";
        String nomeArquivoLocal = "Prontuario.docx";

        String caminhoCompletoArquivoLocal = Paths.get("", nomePastaLocal, nomeArquivoLocal).toAbsolutePath().toString();

        String chaveNoBucket = "documentos_2025/Prontuario_Paciente_XYZ.docx";


        System.out.println("Tentando enviar o arquivo: " + caminhoCompletoArquivoLocal);
        System.out.println("Para o bucket: " + NOME_BUCKET_PRONTUARIOS + " com a chave: " + chaveNoBucket);

        minioProntuario.enviarArquivos(NOME_BUCKET_PRONTUARIOS, chaveNoBucket, caminhoCompletoArquivoLocal);

        System.out.println("\nVerifique o console do MinIO (http://localhost:9001) para ver se o arquivo foi enviado para o bucket '" + NOME_BUCKET_PRONTUARIOS + "'.");
    }

}
