package programmingtheiot.part03.integration.connection;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SystemPerformanceData;
import programmingtheiot.gda.connection.CoapClientConnector;
import programmingtheiot.gda.connection.CoapServerGateway;

public class CoapExchangeTest {
	
	public static final int DEFAULT_TIMEOUT = 5;
	public static final boolean USE_DEFAULT_RESOURCES = true;
	
	private static final Logger _Logger =
		Logger.getLogger(CoapClientToServerConnectorTest.class.getName());
	
	private static CoapServerGateway _ServerGateway = null;
	
	// member var's
	
	private CoapClientConnector coapClient ;
	private IDataMessageListener dataMsgListener ;

	@Test
	public void testSystemPerformancePutMessage()
	{
		SystemPerformanceData spData = new SystemPerformanceData();
		
		String jsonData = DataUtil.getInstance().systemPerformanceDataToJson(spData);
		
		this.coapClient.sendPutRequest(
			ResourceNameEnum.CDA_SYSTEM_PERF_MSG_RESOURCE, null, USE_DEFAULT_RESOURCES, jsonData, DEFAULT_TIMEOUT);
	}

}
