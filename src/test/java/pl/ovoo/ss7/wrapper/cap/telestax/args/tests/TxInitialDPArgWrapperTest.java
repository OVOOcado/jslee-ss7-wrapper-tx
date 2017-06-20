package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import org.mobicents.protocols.ss7.isup.message.parameter.CalledPartyNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.OriginalCalledNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectingNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectionInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserTeleserviceInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.BearerCapabilityWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;
import pl.ovoo.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RedirectionInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxBearerCapabilityWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxHighLayerCompatibilityWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxOriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRedirectionInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxInitialDPArgWrapperTest extends WrapperBaseTest {

    TxInitialDPArgWrapper txInitialDPArgWrapper;

    @Before
    public void setUp() throws Exception {

        txInitialDPArgWrapper = new TxInitialDPArgWrapper();

        CallingPartyNumber callingPartyNumber = isupFactory.createCallingPartyNumber();
        callingPartyNumber.setNatureOfAddresIndicator(CallingPartyNumberWrapper.Nature.NATIONAL.getValue());
        callingPartyNumber.setAddress("0696567765");
        CallingPartyNumberCap callingPartyNumberCap = capFactory.createCallingPartyNumberCap(callingPartyNumber);
        CallingPartyNumberWrapper callingPartyNumberWrapper = new TxCallingPartyNumberWrapper(callingPartyNumberCap);
        txInitialDPArgWrapper.setCallingPartyNumber(callingPartyNumberWrapper);

        CalledPartyNumber calledPartyNumber = isupFactory.createCalledPartyNumber();
        calledPartyNumber.setNatureOfAddresIndicator(CalledPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
        calledPartyNumber.setAddress("0048678987234");
        CalledPartyNumberCap calledPartyNumberCap = capFactory.createCalledPartyNumberCap(calledPartyNumber);
        CalledPartyNumberWrapper calledPartyNumberWrapper = new TxCalledPartyNumberWrapper(calledPartyNumberCap);
        txInitialDPArgWrapper.setCalledPartyNumber(calledPartyNumberWrapper);

        RedirectionInformation redirectionInformation = isupFactory.createRedirectionInformation();
        redirectionInformation
                .setOriginalRedirectionReason(RedirectionInformationWrapper.OriginalReason.UNCONDITIONAL.getValue());
        redirectionInformation.setRedirectingIndicator(RedirectionInformation._RI_CALL_D);
        redirectionInformation.setRedirectionCounter(1);
        redirectionInformation
                .setRedirectionReason(RedirectionInformationWrapper.RedirectingReason.UNCONDITIONAL.getValue());
        RedirectionInformationInap redirectionInformationInap = inapFactory
                .createRedirectionInformationInap(redirectionInformation);
        RedirectionInformationWrapper redirectionInformationWrapper = new TxRedirectionInformationWrapper(
                redirectionInformationInap);
        txInitialDPArgWrapper.setRedirectionInformation(redirectionInformationWrapper);

        UserServiceInformation userServiceInformation = isupFactory.createUserServiceInformation();
        userServiceInformation.setAssignor(UserServiceInformation._ASS_DEFAULT_ASSIGNEE);
        userServiceInformation.setCodingStandart(UserServiceInformation._CS_INTERNATIONAL);
        BearerCap bearerCap = capFactory.createBearerCap(userServiceInformation);
        BearerCapability bearerCapability = capFactory.createBearerCapability(bearerCap);
        BearerCapabilityWrapper bearerCapabilityWrapper = new TxBearerCapabilityWrapper(bearerCapability);
        txInitialDPArgWrapper.setBearerCapability(bearerCapabilityWrapper);

        UserTeleserviceInformation userTeleserviceInformation = isupFactory.createUserTeleserviceInformation();
        userTeleserviceInformation.setCodingStandard(UserTeleserviceInformation._CODING_STANDARD_ISO_IEC);
        userTeleserviceInformation.setHighLayerCharIdentification(UserTeleserviceInformation._HLCI_FG_2_3);
        HighLayerCompatibilityInap highLayerCompatibilityInap = inapFactory
                .createHighLayerCompatibilityInap(userTeleserviceInformation);
        HighLayerCompatibilityWrapper highLayerCompatibilityWrapper = new TxHighLayerCompatibilityWrapper(
                highLayerCompatibilityInap);
        txInitialDPArgWrapper.setHighLayerCompatibility(highLayerCompatibilityWrapper);

        OriginalCalledNumber originalCalledNumber = isupFactory.createOriginalCalledNumber();
        originalCalledNumber.setNatureOfAddresIndicator(OriginalCalledNumberWrapper.Nature.INTERNATIONAL.getValue());
        originalCalledNumber.setAddress("0048143456763");
        originalCalledNumber.setAddressRepresentationRestrictedIndicator(1);
        originalCalledNumber.setNumberingPlanIndicator(2);
        OriginalCalledNumberCap originalCalledNumberCap = capFactory
                .createOriginalCalledNumberCap(originalCalledNumber);
        OriginalCalledNumberWrapper originalCalledPartyID = new TxOriginalCalledNumberWrapper(originalCalledNumberCap);
        txInitialDPArgWrapper.setOriginalCalledPartyID(originalCalledPartyID);

        RedirectingNumber redirectingNumber = isupFactory.createRedirectingNumber();
        redirectingNumber.setNatureOfAddresIndicator(RedirectingPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
        redirectingNumber.setAddress("0048567432567");
        RedirectingPartyIDCap redirectingPartyIDCap = capFactory.createRedirectingPartyIDCap(redirectingNumber);
        RedirectingPartyNumberWrapper redirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(
                redirectingPartyIDCap);
        txInitialDPArgWrapper.setRedirectingPartyID(redirectingPartyNumberWrapper);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInitialDPArgWrapper);
        TxInitialDPArgWrapper tx = (TxInitialDPArgWrapper) deserializeFromFile();

        assertTrue(txInitialDPArgWrapper.getTxCallingPartyNumber().getCallingPartyNumber()
                .getNatureOfAddressIndicator() == tx.getTxCallingPartyNumber().getCallingPartyNumber()
                        .getNatureOfAddressIndicator());
        assertTrue(txInitialDPArgWrapper.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()
                .equals(tx.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()));

        assertTrue(txInitialDPArgWrapper.getTxCalledPartyNumber().getCalledPartyNumber()
                .getNatureOfAddressIndicator() == tx.getTxCalledPartyNumber().getCalledPartyNumber()
                        .getNatureOfAddressIndicator());
        assertTrue(txInitialDPArgWrapper.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()
                .equals(tx.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()));

        assertTrue(txInitialDPArgWrapper.getTxRedirectionInformationInap().getRedirectionInformation()
                .getOriginalRedirectionReason() == tx.getTxRedirectionInformationInap().getRedirectionInformation()
                        .getOriginalRedirectionReason());
        assertTrue(txInitialDPArgWrapper.getTxRedirectionInformationInap().getRedirectionInformation()
                .getRedirectingIndicator() == tx.getTxRedirectionInformationInap().getRedirectionInformation()
                        .getRedirectingIndicator());

        assertTrue(txInitialDPArgWrapper.getTxBearerCapability().getBearerCap().getUserServiceInformation()
                .getAssignor() == tx.getTxBearerCapability().getBearerCap().getUserServiceInformation().getAssignor());
        assertTrue(txInitialDPArgWrapper.getTxBearerCapability().getBearerCap().getUserServiceInformation()
                .getCodingStandart() == tx.getTxBearerCapability().getBearerCap().getUserServiceInformation()
                        .getCodingStandart());

        assertTrue(txInitialDPArgWrapper.getTxHighLayerCompatibility().getHighLayerCompatibility()
                .getHighLayerCharIdentification() == tx.getTxHighLayerCompatibility().getHighLayerCompatibility()
                        .getHighLayerCharIdentification());
        assertTrue(txInitialDPArgWrapper.getTxHighLayerCompatibility().getHighLayerCompatibility()
                .getCodingStandard() == tx.getTxHighLayerCompatibility().getHighLayerCompatibility()
                        .getCodingStandard());

        assertTrue(txInitialDPArgWrapper.getTxOriginalCalledPartyID().getOriginalCalledNumber()
                .getAddressRepresentationRestrictedIndicator() == tx.getTxOriginalCalledPartyID()
                        .getOriginalCalledNumber().getAddressRepresentationRestrictedIndicator());
        assertTrue(txInitialDPArgWrapper.getTxOriginalCalledPartyID().getOriginalCalledNumber().getAddress()
                .equals(tx.getTxOriginalCalledPartyID().getOriginalCalledNumber().getAddress()));

        assertTrue(txInitialDPArgWrapper.getTxRedirectingPartyID().getRedirectingNumber().getAddress()
                .equals(tx.getTxRedirectingPartyID().getRedirectingNumber().getAddress()));
        assertTrue(txInitialDPArgWrapper.getTxRedirectingPartyID().getRedirectingNumber()
                .getNatureOfAddressIndicator() == tx.getTxRedirectingPartyID().getRedirectingNumber()
                        .getNatureOfAddressIndicator());

    }

}
