package rmi_inter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.Instant;

//INTERFACE DO OBJETO REMOTO DO SERVICO TEMPERATURA
public interface ServicesInterface extends Remote {

	 public Float getTemp(Instant tsp) throws RemoteException;

}