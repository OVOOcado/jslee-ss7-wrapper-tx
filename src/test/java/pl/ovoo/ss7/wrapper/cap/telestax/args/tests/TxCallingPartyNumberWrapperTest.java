package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallingPartyNumberWrapperTest extends WrapperBaseTest {

	TxCallingPartyNumberWrapper txCallingPartyNumberWrapper;

	@Before
	public void setUp() throws Exception {

		CallingPartyNumber callingPartyNumber = isupFactory.createCallingPartyNumber();
		callingPartyNumber.setNatureOfAddresIndicator(CallingPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
		callingPartyNumber.setAddress("0048123456789");
		CallingPartyNumberCap callingPartyNumberCap = capFactory.createCallingPartyNumberCap(callingPartyNumber);
		txCallingPartyNumberWrapper = new TxCallingPartyNumberWrapper(callingPartyNumberCap);
	}

	@Test
	public void testSerialization() throws ClassNotFoundException, IOException, Ss7WrapperException, CAPException {
		serializeToFile(txCallingPartyNumberWrapper);
		TxCallingPartyNumberWrapper tx = (TxCallingPartyNumberWrapper) deserializeFromFile();

		assertTrue(txCallingPartyNumberWrapper.getNature().getValue() == tx.getNature().getValue());
		assertTrue(txCallingPartyNumberWrapper.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()
				.equals(tx.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()));
	}

}
