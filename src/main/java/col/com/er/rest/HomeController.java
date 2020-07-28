package col.com.er.rest;

import col.com.er.entity.Cbanks;
import col.com.er.service.CbanksService;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "Language API", description = "Operations pertaining to Home")
/*To customize my api */
@RequestMapping("/api/v1")

public class HomeController {

    @Autowired
    CbanksService cbanksService;

    @ApiOperation(value = "View a list of available languages", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @GetMapping("/hello")
    public String hello() {
        return ("Hello");
    }

    @GetMapping(value = "/catalogs/banks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cbanks>> getCbanks() {
        final List<Cbanks> cBanks = cbanksService.listCbanks();
        return new ResponseEntity<>(cBanks, HttpStatus.OK);
    }

}
