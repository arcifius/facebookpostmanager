package br.com.arcifius.robot.network;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.arcifius.robot.interfaces.IFetcher;
import br.com.arcifius.robot.models.Course;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Web Fetcher
 *
 * @author Augusto Russo
 */
public class WebFetcher implements IFetcher {
    @Override
    public List<Course> fetch(String school) throws MalformedURLException, IOException {
        URL url = new URL("https://" + school + ".eadbox.com/api/courses");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Type listType = new TypeToken<List<Course>>(){}.getType();
        List<Course> courses = new Gson().fromJson(reader, listType);
        return courses;
    }
}