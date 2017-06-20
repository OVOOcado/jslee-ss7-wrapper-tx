package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.DomainType;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxAnyTimeInterrogationArgWrapper;

public class TxAnyTimeInterrogationArgWrapperTest extends WrapperBaseTest {

	TxAnyTimeInterrogationArgWrapper txAnyTimeInterrogationArgWrapper;

	@Before
	public void setUp() throws Exception {

		final ISDNAddressString isdnAddressString = mapParameterFactory
				.createISDNAddressString(AddressNature.international_number, NumberingPlan.ISDN, "0048765678456");
		ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(
				AddressNature.national_significant_number, NumberingPlan.land_mobile, "0048678987345");
		SubscriberIdentity subscriberIdentity = mapParameterFactory.createSubscriberIdentity(addressString);
		MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 100 },
				new byte[] { 64 });
		ArrayList<MAPPrivateExtension> mapPrivateExtensions = new ArrayList<MAPPrivateExtension>(1);
		mapPrivateExtensions.add(mapPrivateExtension);
		MAPExtensionContainer mapExtensionContainer = mapParameterFactory
				.createMAPExtensionContainer(mapPrivateExtensions, new byte[] { 32 });
		RequestedInfo requestedInfo = mapParameterFactory.createRequestedInfo(true, true, mapExtensionContainer, true,
				DomainType.csDomain, false, false, true);
		AnyTimeInterrogationRequest anyTimeInterrogationRequest = mapParameterFactory.createAnyTimeInterrogationRequest(
				subscriberIdentity, requestedInfo, addressString, mapExtensionContainer);

		txAnyTimeInterrogationArgWrapper = new TxAnyTimeInterrogationArgWrapper(anyTimeInterrogationRequest);
	}

	@Override
	public void testSerialization()
			throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

		serializeToFile(txAnyTimeInterrogationArgWrapper);
		TxAnyTimeInterrogationArgWrapper tx = (TxAnyTimeInterrogationArgWrapper) deserializeFromFile();

		assertTrue(txAnyTimeInterrogationArgWrapper.getTxRequestedInfo().getCurrentLocation() == tx.getTxRequestedInfo()
				.getCurrentLocation());
		assertTrue(txAnyTimeInterrogationArgWrapper.getTxAnyTimeInterrogationRequest().getSubscriberIdentity()
				.getMSISDN().equals(tx.getTxAnyTimeInterrogationRequest().getSubscriberIdentity().getMSISDN()));

	}

}
