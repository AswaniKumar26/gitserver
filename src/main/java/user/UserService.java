package user;

import com.aswin.learning.grpc.User.APIResponse;
import com.aswin.learning.grpc.User.Empty;
import com.aswin.learning.grpc.User.LoginRequest;
import com.aswin.learning.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.login(request, responseObserver);
		System.out.println("Inside Login");
		String username = request.getUsername();
		String password = request.getPassword();
		
		// Response cannot be sent directly, hence build the response with required data
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			response.setResponseCode(0).setResponsemessage("SUCCESS");
		}
		else {
			response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");
		}
		
		//Sending data back to the client by pushing response into response observer.
		responseObserver.onNext(response.build());
		//Close Current call.
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		APIResponse.Builder response = APIResponse.newBuilder();
		response.setResponseCode(0).setResponsemessage("SUCCESS");

		
		//Sending data back to the client by pushing response into response observer.
		responseObserver.onNext(response.build());
		//Close Current call.
		responseObserver.onCompleted();
	}

}
