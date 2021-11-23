package co.edu.ucundinamarca.negocio.chartsservice.controllers;


import co.edu.ucundinamarca.negocio.chartsservice.repository.CuentaRepository;
import co.edu.ucundinamarca.negocio.chartsservice.repository.HabitacionRepository;
import co.edu.ucundinamarca.negocio.chartsservice.repository.ReservacionRepository;
import co.edu.ucundinamarca.negocio.chartsservice.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("chart")
public class ChartsController {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/reservaciones")
    public Long allReservations(){
        return reservacionRepository.count();
    }

    @GetMapping("/reservaciones/month")
    public int[] allReservationsWithMonth(){
        List<Integer> months = reservacionRepository.findMonthInReservations();
        return arroundMonths(months);
    }

    @GetMapping("/habitaciones")
    public Long allRooms(){
        return habitacionRepository.count();
    }

    @GetMapping("/ocupacion")
    public Integer allOcupation(){
        return habitacionRepository.allOcupation();
    }

    @GetMapping("/disponible")
    public Integer allDisponible(){
        return habitacionRepository.allDisponible();
    }

    @GetMapping("/limpieza")
    public Integer allClean(){
        return habitacionRepository.allClean();
    }

    @GetMapping("/mantenimiento")
    public Integer allMantenaince(){
        return habitacionRepository.allMantenaince();
    }



    @GetMapping("/ventas")
    public Long allBuys(){
        return ventasRepository.count();
    }

    @GetMapping("/ventas/month")
    public int[] allBuysInMonths(){
        List<Integer> months = ventasRepository.findMonthInBuy();
        return arroundMonths(months);
    }

    @GetMapping("servicios")
    public Long allCounts(){
        return cuentaRepository.count();
    }

    @GetMapping("/servicios/month")
    public int[] allCountsWithMonth(){
        List<Integer> months = cuentaRepository.allCounts();
        return arroundMonths(months);
    }

    public int[] arroundMonths(List<Integer> months){
        int[] counts = new int[12];

        for(Integer month: months) {
            switch (month) {
                case 1:
                    counts[0] = counts[0] + 1;
                    break;
                case 2:
                    counts[1] = counts[1] + 1;
                    break;
                case 3:
                    counts[2] = counts[2] + 1;
                    break;
                case 4:
                    counts[3] = counts[3] + 1;
                    break;
                case 5:
                    counts[4] = counts[4] + 1;
                    break;
                case 6:
                    counts[5] = counts[5] + 1;
                    break;
                case 7:
                    counts[6] = counts[6] + 1;
                    break;
                case 8:
                    counts[7] = counts[7] + 1;
                    break;
                case 9:
                    counts[8] = counts[8] + 1;
                    break;
                case 10:
                    counts[9] = counts[9] + 1;
                    break;
                case 11:
                    counts[10] = counts[10] + 1;
                    break;
                case 12:
                    counts[11] = counts[11] + 1;
                    break;
                default:
                    break;
            }
        }

        return counts;
    }

}
