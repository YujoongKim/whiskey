package com.techelevator.controller;

import com.techelevator.dao.WhiskeyDao;
import com.techelevator.model.Whiskey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin // ??
@RestController
public class AppController {
    @Autowired // dependency injection
    WhiskeyDao dao; //instantiate whiskyDao to use

    /**
     * Get request for getting all whiskey information from DB
     * @return list of whiskey object
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/allWhiskey", method = RequestMethod.GET )
    public List<Whiskey> findAll(){
        return  dao.findAll();
    }

    /**
     * find a whiskey object by id
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/getWhiskeyById/{id}", method = RequestMethod.GET)
    public Whiskey findWhiskeyById(@Valid @PathVariable int id) {
        return dao.findWhiskeyById(id);
    }

    /**
     * Create whiskey object in DB wish passed information from User
     * @param whiskey
     * @return created whiskey object
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/newWhiskey", method = RequestMethod.POST)
    public Whiskey createWhiskey(@Valid @RequestBody Whiskey whiskey) {
        return dao.createWhiskey(whiskey);
    }

    /**
     * updating existing whiskey object with put end point
     * @param id
     * @param volume
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/updateWhiskey")
    // /updateWhiskey?id=1&volume=50
    public void updateVolume(@Valid @RequestParam int id, @RequestParam int volume) {
        Whiskey whiskey = dao.findWhiskeyById(id);
        int newVolume = 0;
        if ((whiskey.getVolume() > 0) && (whiskey.getVolume() > volume)) {
            newVolume =  whiskey.getVolume() - volume;

        }else {
            newVolume = 0;
        }
        dao.updateVolume(id,newVolume);
    }
}
