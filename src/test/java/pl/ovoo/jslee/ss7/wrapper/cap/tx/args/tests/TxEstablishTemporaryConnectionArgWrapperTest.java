/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxGenericDigitsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxGenericNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;


/**
 * The Class TxEstablishTemporaryConnectionArgWrapperTest.
 */
public class TxEstablishTemporaryConnectionArgWrapperTest extends WrapperBaseTest {

    /** The tx establish temporary connection arg wrapper. */
    TxEstablishTemporaryConnectionArgWrapper txEstablishTemporaryConnectionArgWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        txEstablishTemporaryConnectionArgWrapper = new TxEstablishTemporaryConnectionArgWrapper();

        GenericDigits genericDigits = isupFactory.createGenericDigits();
        genericDigits.setDecodedDigits(2, "0048567456946");
        genericDigits.setEncodedDigits(new byte[] { 64 });
        genericDigits.setTypeOfDigits(GenericDigits._TOD_AUTHORIZATION_CODE);
        genericDigits.setEncodingScheme(GenericDigits._ENCODING_SCHEME_BCD_ODD);
        GenericDigitsWrapper genericDigitsWrapper = new TxGenericDigitsWrapper(genericDigits);

        txEstablishTemporaryConnectionArgWrapper.setAssistingDialogCorrelationID(genericDigitsWrapper);

        GenericNumber genericNumber = isupFactory.createGenericNumber();
        genericNumber.setAddressRepresentationRestrictedIndicator(1);
        genericNumber.setNumberIncompleter(true);
        genericNumber.setNumberingPlanIndicator(GenericNumberWrapper.NumberingPlan.ISDN.getValue());
        genericNumber.setScreeningIndicator(GenericNumber._SI_USER_PROVIDED_VERIFIED_FAILED);
        genericNumber.setNatureOfAddresIndicator(GenericNumberWrapper.Nature.INTERNATIONAL.getValue());
        genericNumber.setAddress("0048231757215");
        GenericNumberWrapper genericNumberWrapper = new TxGenericNumberWrapper(genericNumber);

        txEstablishTemporaryConnectionArgWrapper.setAssistingSSPIPRoutingAddress(genericNumberWrapper);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txEstablishTemporaryConnectionArgWrapper);
        TxEstablishTemporaryConnectionArgWrapper tx = (TxEstablishTemporaryConnectionArgWrapper) deserializeFromFile();

        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID()
                .getEncodingScheme() == tx.getTxAssistingDialogCorrelationID().getEncodingScheme());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID().getTypeOfDigits() == tx
                .getTxAssistingDialogCorrelationID().getTypeOfDigits());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress()
                .getNatureOfAddressIndicator() == tx.getTxAssistingSSPIPRoutingAddress().getNatureOfAddressIndicator());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress().getAddress()
                .equals(tx.getTxAssistingSSPIPRoutingAddress().getAddress()));
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID().getCode() == tx
                .getTxAssistingDialogCorrelationID().getCode());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress().getCode() == tx
                .getTxAssistingSSPIPRoutingAddress().getCode());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress()
                .getScreeningIndicator() == tx.getTxAssistingSSPIPRoutingAddress().getScreeningIndicator());
    }

}
