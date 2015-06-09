package twitterJava;
import java.io.IOException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Autorizacion
{
    Twitter OAuthTwitter;
        public Autorizacion()throws IOException, TwitterException
        {
            //Constructor de la clase
            ConfigurationBuilder configBuilder = new ConfigurationBuilder();
            //Insertar las claves dadas por la API de Twitter
            configBuilder.setDebugEnabled(true)
            .setOAuthConsumerKey("")
            .setOAuthConsumerSecret("")
            .setOAuthAccessToken("")
            .setOAuthAccessTokenSecret("");
            OAuthTwitter = new TwitterFactory(configBuilder.build()).getInstance();
        }
    public Twitter getInstance()
    {
        return OAuthTwitter;
    }
}
