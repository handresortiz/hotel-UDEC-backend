package co.edu.ucundinamarca.negocio.chartsservice.controllers;


import co.edu.ucundinamarca.negocio.chartsservice.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("chart")
public class ChartReservacionController {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @GetMapping("/reservaciones")
    public Long allReservations(){
        return reservacionRepository.count();
    }

    @GetMapping("/reservaciones/month")
    public int[] allReservationsWithMonth(){
        List<Integer> months = new ArrayList<>();
        int[] counts = new int[12];

        months = reservacionRepository.findMonthInReservations();

        for(Integer month: months){
            switch (month){
                case 1:
                    counts[0]  = counts[0] + 1;
                    break;
                case 2:
                    counts[1]  = counts[1] + 1;
                    break;
                case 3:
                    counts[2]  = counts[2] + 1;
                    break;
                case 4:
                    counts[3]  = counts[3] + 1;
                    break;
                case 5:
                    counts[4]  = counts[4] + 1;
                    break;
                case 6:
                    counts[5]  = counts[5] + 1;
                    break;
                case 7:
                    counts[6]  = counts[6] + 1;
                    break;
                case 8:
                    counts[7]  = counts[7] + 1;
                    break;
                case 9:
                    counts[8]  = counts[8] + 1;
                    break;
                case 10:
                    counts[9]  = counts[9] + 1;
                    break;
                case 11:
                    counts[10] =  counts[10]  + 1;
                    break;
                case 12:
                    counts[11] =  counts[11]  + 1;
                    break;
            }
        }
        return counts;
    }


}
