package app.commonerp.hometheatre.presentationtier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.commonerp.hometheatre.businesstier.CountryManager;

@Controller
@RequestMapping(value = "/hometheatre/setup/country")
public class CountryController {
	@Autowired
	private CountryManager countryManager;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getCountryList(Model model) {
		model.addAttribute("countryList", countryManager.getCountryList());
		return "hometheatre/setup/country";
	}
	@RequestMapping(value = "/countryList", method = RequestMethod.GET)
	public String getCountryListJson(Model model) {

		model.addAttribute("countryList", countryManager.getCountryList());

		return "hometheatre/setup/countryList";
	}

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	@ResponseBody
	public String saveCountry(HttpServletRequest request,
			HttpServletResponse response) {
		String status = countryManager.saveCountry(request,response);
		return status;
	}

	@RequestMapping(value = "/setup/country/{id}/delete", method = RequestMethod.GET)
	public ModelAndView deleteCountry(@PathVariable long id) {
		countryManager.deleteCountry(id);
		
		return new ModelAndView("redirect:/hometheatre/setup/country");
	}

	@RequestMapping(value = "/hometheatre/setup/getCountry", method = RequestMethod.POST)
	@ResponseBody
	public String getCountry(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String message = countryManager.getCountry(id);

		return message;
	}

	
	/*RequestMapping(value = "/searchMovie", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchMovie(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        String strMovie = request.getParameter("movieName");
        String rackId=request.getParameter("rack");
        String rowNo=request.getParameter("rowNo");
       
        if(strMovie.equals("") == false)
        {
       
        model.addAttribute("rackList", rackRepository.findAll());
//        model.addAttribute("movieList", movieRepository.findAll());
        model.addAttribute("languageList", languageRepository.findAll());
        model.addAttribute("countryList", countryRepository.findAll());
       
       
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Movie> criterias = criteriaBuilder
                .createQuery(Movie.class);
       
        Root<Movie> movie = criterias.from(Movie.class);
        Predicate movieNameCondition = null;
              
        //Predicate predCondmovie = criteriaBuilder.equal(movie.get("movieName"), strMovie);
        if(!ObjectUtils.isEmpty(strMovie)){
            movieNameCondition = criteriaBuilder.like(movie.<String>get("movieName"), "%"+strMovie+"%");           
        }
       
        Predicate rackCondition = null;
        Predicate rowCondition = null;
       
        if(!ObjectUtils.isEmpty(rackId)){
            rackCondition = criteriaBuilder.equal(movie.get("rack"), rackRepository.findOne(Long.parseLong(rackId)));
            movieNameCondition = criteriaBuilder.and(movieNameCondition,rackCondition);
        }
        if(!ObjectUtils.isEmpty(rowNo)){
            rowCondition = criteriaBuilder.equal(movie.get("rowNo"),rowNo);
            movieNameCondition = criteriaBuilder.and(movieNameCondition,rowCondition);
        }
        Predicate predCondrowNo = criteriaBuilder.equal(
                movie.get("rowNo"), rowNo);
   
       
       
        List<Movie> movieList = new ArrayList<Movie>();
       
        if(!ObjectUtils.isEmpty(movieNameCondition) ){
            criterias.where(movieNameCondition);
            movieList = em.createQuery(criterias).getResultList();
        }else{
            model.addAttribute("movieList", movieRepository.findAll());
        }
       
        if (movieList.size() > 0) {
            model.addAttribute("movieList", movieList);
           
        }else{
            model.addAttribute("_ERROR_MESSAGE_", "no such found");
        }
       
        if(ObjectUtils.isEmpty(movieNameCondition) ){
            model.addAttribute("movieList", movieRepository.findAll());
        }
        System.out.println("movieList: "+movieList);
       
   
       
//        return "public/home";
       
       
       
        return new ModelAndView("public/home");
       
       
    }*/
}
