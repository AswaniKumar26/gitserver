package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 System.out.println("starting GRPC Server");
		 // Set a port and publish service.
		 Server server = ServerBuilder.forPort(10001).addService(
				 new UserService()).build();

		 server.start();
		 System.out.println("server started at "+ server.getPort());		
	        server.awaitTermination();
	        System.out.println("server shutdown complete");
	        Runtime.getRuntime().addShutdownHook( new Thread( () -> {
	            System.out.println("Received Shutdown Signal");
	            server.shutdown();
	            System.out.println("Shutdown Successful");
	        }));	        

	}

}
