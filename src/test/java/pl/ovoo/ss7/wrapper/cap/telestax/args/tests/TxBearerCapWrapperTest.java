package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformationBase;

import pl.ovoo.ss7.wrapper.cap.telestax.args.TxBearerCapWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxBearerCapWrapperTest extends WrapperBaseTest {

	TxBearerCapWrapper txBearerCapWrapper;

	@Before
	public void setUp() throws Exception {
	    
		UserServiceInformation createUserServiceInformation = isupFactory.createUserServiceInformation();
		createUserServiceInformation.setCodingStandart(UserServiceInformation._CS_INTERNATIONAL);
		createUserServiceInformation.setCustomInformationTransferRate(UserServiceInformationBase._ITR_1536);
		createUserServiceInformation.setInformationTransferCapability(UserServiceInformation._ITR_MULTIRATE);
		BearerCap bearerCap = capFactory.createBearerCap(createUserServiceInformation);
		txBearerCapWrapper = new TxBearerCapWrapper(bearerCap);

	}

	@Test
	public void testSerialization() throws ClassNotFoundException, IOException, CAPException {
	    
		serializeToFile(txBearerCapWrapper);
		TxBearerCapWrapper tx = (TxBearerCapWrapper) deserializeFromFile();

		assertTrue(txBearerCapWrapper.getTxBearerCap().getUserServiceInformation().getCodingStandart() == tx
				.getTxBearerCap().getUserServiceInformation().getCodingStandart());
		assertTrue(
				txBearerCapWrapper.getTxBearerCap().getUserServiceInformation().getInformationTransferCapability() == tx
						.getTxBearerCap().getUserServiceInformation().getInformationTransferCapability());
	}

}
