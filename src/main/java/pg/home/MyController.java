package pg.home;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import pg.home.dao.CarDao;
import pg.home.entities.CarEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/cars")
public class MyController {

    @Inject
    private CarDao carRepository;

    @ConfigProperty(name = "custom.config")
    private String customConfig;

    @ConfigProperty(name =  "mycustom.lobby")
    private String lobby;

    @Path("/pipi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPiPi() {
        return String.format("PiPi lobby:[%s]", lobby) ;
    }

    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<CarEntity> getCars() {
        return carRepository.findAll();
    }

    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public CarEntity createCar() {
        final CarEntity carEntity = new CarEntity(true, LocalDateTime.now(), LocalDateTime.now());
        carEntity.setDescription(customConfig);
        return carRepository.save(carEntity);
    }
}
