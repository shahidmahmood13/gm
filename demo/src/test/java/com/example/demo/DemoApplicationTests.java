package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Controller.MovieController;
import com.example.demo.Controller.ReviewController;
import com.example.demo.Controller.ReviewerController;
import com.example.demo.Model.Movie;
import com.example.demo.Model.Review;
import com.example.demo.Model.Reviewer;
import com.example.demo.Repo.MovieRepo;
import com.example.demo.Repo.ReviewRepo;
import com.example.demo.Repo.ReviewerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.MockitoAnnotations;
@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
class DemoApplicationTests {

	
	private MockMvc mvc;

    private MockMvc mvc2;

    @Mock
    private MovieRepo movieRepository;

	@Mock
    private ReviewerRepo reviewerRepository;

    @Mock
    private ReviewRepo reviewsRepository;


    @InjectMocks
    private ReviewerController reviewerController;

    @InjectMocks
    private MovieController movieController;

    @InjectMocks 
    private ReviewController reviewController;

    private JacksonTester<Movie> jsonMovie;
    private JacksonTester<Iterable<Review>> jsonReview;

    private JacksonTester<Reviewer> jsonReviewer;
 
    @Autowired
    private MovieController movieController2;
    
	@Autowired
private ObjectMapper objectMapper;

@Autowired
private MockMvc mockMvc;

// @Autowired
// private MovieRepo movieRepository;
  
@BeforeEach
public void setUp() {
	JacksonTester.initFields(this, new ObjectMapper());
	mvc  = MockMvcBuilders.standaloneSetup(movieController).build();
	mvc2 = MockMvcBuilders.standaloneSetup(reviewerController).build();
}


	@Test
	public  void contextLoads() {
	}
  


	// @Test
	// public void canCreateANewBook() throws Exception {
	// 	Movie Movie1 = new Movie(1, "let us c",2000, "Romance", "120");
	// 	Movie Movie2 = new Movie(2, "let us c",2010, "Dramatic", "180");

    //     List<Movie> AllMovie = new ArrayList<>();
    //     AllMovie.add(Movie1);
    //     AllMovie.add(Movie2);
    //     when(movieRepository.findAll()).thenReturn(AllMovie);
	// 	mvc.perform(get("/Movie/getall"))
	// 			.contentType(MediaType.APPLICATION_JSON)
	// 			.andExpect(status().isOk())
	// 			.andExpect(content().json(jsonMovie.write(AllMovie).getJson()));
	// }


    @Test
    public void getAllMovie() throws Exception
    {
        Movie Movie1= new Movie(1L, "Get Out", 2017, "Horror", "92");
        Movie Movie2=new Movie(2L, "Inception", 2010, "Sci-Fi", "148");
        Movie Movie3=  new Movie(3L, "The Shawshank Redemption", 1994, "Drama", "142");

        List<Movie> Movie = new ArrayList<>();
        Movie.add(Movie1);
        Movie.add(Movie2);
        Movie.add(Movie3);

        when(movieRepository.findAll()).thenReturn(Movie);
        mvc.perform(get("/Movie/getall")
            .contentType(MediaType.APPLICATION_JSON));
            // .andExpect(status().isOk());
    }
    @Test
	public  void contextLoad() {
	}
	
    @Test
    public void getRecordbyId()throws Exception{
		
        Movie Movie1 = new Movie(2, "the dark",  2020, "darama", "30min");
        // Reviews reviews = new Reviews();
        // Movie1.setReviews(null);
         
        when(movieRepository.findById((long) 2)).thenReturn( Optional.ofNullable(Movie1) );
        mvc.perform(get("/movies/2")
            .contentType(MediaType.APPLICATION_JSON)
        );
    }

    // @Test
    // public void testUpdateMovie() throws Exception {
    //     Movie updatedMovie = new Movie(2L, "Updated Title", 2023, "Action", "120");
    //     MovieRepo movieRepository = Mockito.mock(MovieRepo.class);

    //     when(movieRepository.findById(2L)).thenReturn(Optional.of(new Movie(2L, "Original Title", 2022, "Adventure", "90")));
    //     when(movieRepository.save(any(Movie.class))).thenReturn(updatedMovie);

    //      movieController.updatedMovie(movieRepository);

    //     mockMvc.perform(put("/Movie/update/2")
    //             .content("{\"movieId\": 2, \"title\": \"Updated Title\", \"year\": 2023, \"genre\": \"Action\", \"runtime\": \"120\"}")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.title").value("Updated Title"))
    //             .andExpect(jsonPath("$.year").value(2023))
    //             .andExpect(jsonPath("$.genre").value("Action"))
    //             .andExpect(jsonPath("$.runtime").value("120"));
    // }

   
   
    @Test
    public void getAllReviewer() throws Exception {
      
        Reviewer reviewer1 =  new Reviewer(1L, "JohnDoe","2020/march/10" , 5);
        Reviewer reviewer2 = new Reviewer(3L, "xyz","2020/march/10" , 5);
        Reviewer reviewer3 = new Reviewer(2L, "ali babab","2020/march/10" , 5);
        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(reviewer1);
        reviewers.add(reviewer2);
        reviewers.add(reviewer3);

        when(reviewerRepository.findAll()).thenReturn(reviewers);
        mvc.perform(get("/reviewer/getall")
                .contentType(MediaType.APPLICATION_JSON));

    }




 @Test
    public void getUserbyId()throws Exception{
		
        Reviewer reviewer1 =  new Reviewer((long) 2, "JohnDoe","2020/march/10" , 5);
         
        when(reviewerRepository.findById((long) 2)).thenReturn( Optional.ofNullable(reviewer1));
        mvc.perform(get("/reviewer/find/2")
        .contentType(MediaType.APPLICATION_JSON));

    }



}
