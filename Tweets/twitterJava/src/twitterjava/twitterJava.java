package twitterjava;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.*;
import twitterJava.Autorizacion;

public class twitterJava
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            Autorizacion autorization=new Autorizacion();
            Twitter twitter=autorization.getInstance();
            //Se establece la consulta a la API, el tipo de la respuesta, su idioma y la cantidad de tweets.
            Query consulta = new Query(":)");
            consulta.setResultType(Query.ResultType.recent);
            consulta.setLang("es");
            consulta.setCount(100);
            List <Status> tweets =twitter.search(consulta).getTweets();
            
            try
            {
                fichero = new FileWriter("positivos.txt",true);
                pw = new PrintWriter(fichero);
                
                for(int i=0;i<tweets.size();i++)
                {
                    Status tweet=tweets.get(i);
                    pw.println(tweet.getText());
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                
                try
                {
                    if (null != fichero) fichero.close();
                }
                catch (Exception e2)
                {
                    e2.printStackTrace();
                }
                System.out.println("Tweets descargados: "+tweets.size()+".");
            }
        }
        catch (TwitterException ex)
        {
            Logger.getLogger(twitterJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
