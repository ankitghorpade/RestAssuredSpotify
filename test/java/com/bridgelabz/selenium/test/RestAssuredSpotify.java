package com.bridgelabz.selenium.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredSpotify {
    public String token = " ";
    public static String userId;
    public static int playlistId;


  @BeforeTest
    public void setUp(){
      token = "Bearer BQD4ESeoFo420Qx9nQFJFdRwyixuvxyxzLS7VUa6N3kvvF4B51aQX0_XSaxqJVxDROSEn2LTKstvwaOMB02j_35B0vriUWhM-mBPLqpgVZllArwLMPQ5v8HX065HtuZy54y_w4loXMilb9EheFYcmbhzIldrtvNemjQwnHSNKTmachi2Yn1BAi-fWKmhIh90cra0AvTQNS81O7QLyEz6RtOalnce8kuKcfUDNTk9IPtjQM4OUi-bj7DKZPVFHNg2QT55bSBbGOwNr8m4H2XRkNukSWW00016IYYtjMZv";
    }

  @Test
    public void getUser_profile(){
       Response response =given().contentType(ContentType.JSON)
              .accept(ContentType.JSON).header("Authorization",token)
              .when()
              .get("https://api.spotify.com/v1/me");
      System.out.println("Response print using sout:" + response);
      userId = response.path("id");
    System.out.println("User ID : +userId");
      response.prettyPrint();

  }

@Test
  public void getCurrent_userProfile(){
  Response response =given().contentType(ContentType.JSON)
          .accept(ContentType.JSON).header("Authorization",token)
          .when()
          .get("https://api.spotify.com/v1/users/"+ userId+ "/" );
  response.prettyPrint();


    }

    @Test
    public void  Create_Playlist() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"New Playlist\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when().post("https://api.spotify.com/v1/users/tcchpcvyqhghxobs3iqjc21ik/playlists");
        System.out.println("Response print using sout: " + response);
        response.prettyPrint();
    }

    @Test
    public void get_List_of_current_user_playlist(){
        Response response =given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists" );
        response.prettyPrint();


    }
    @Test
    public void Get_a_Playlist_Cover_Image(){
        Response response =given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/4s9SlVxnbozND07V7fOo56/images" );
        response.prettyPrint();


    }
    @Test
    public void Get_a_Playlist_Item(){
        Response response =given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/6Brn3SmOJpk2sxZBEKF3RQ/tracks" );
        response.prettyPrint();


    }
    @Test
    public void Get_a_Playlist(){
        Response response =given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/6Brn3SmOJpk2sxZBEKF3RQ" );
        response.prettyPrint();


    }

    @Test
    public void Get_a_List_Of_user_Playlist(){
        Response response =given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/users/"+ userId +"/playlists" );
        response.prettyPrint();


    }
}





