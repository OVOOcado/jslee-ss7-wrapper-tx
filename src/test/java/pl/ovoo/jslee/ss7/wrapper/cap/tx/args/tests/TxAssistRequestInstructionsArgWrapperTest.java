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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;

import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxAssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxGenericNumberWrapper;


/**
 * The Class TxAssistRequestInstructionsArgWrapperTest.
 */
public class TxAssistRequestInstructionsArgWrapperTest extends WrapperBaseTest {

    /** The tx assist request instructions arg wrapper. */
    TxAssistRequestInstructionsArgWrapper txAssistRequestInstructionsArgWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        txAssistRequestInstructionsArgWrapper = new TxAssistRequestInstructionsArgWrapper();

        GenericNumber genericNumber = isupFactory.createGenericNumber();
        genericNumber.setNatureOfAddresIndicator(GenericNumberWrapper.Nature.INTERNATIONAL.getValue());
        genericNumber.setAddress("0048986235172");
        genericNumber.setNumberQualifierIndicator(GenericNumber._NQIA_CALLING_PARTY_NUMBER);
        genericNumber.setScreeningIndicator(GenericNumber._SI_USER_PROVIDED_VERIFIED_FAILED);
        genericNumber.setAddressRepresentationRestrictedIndicator(123456789);
        genericNumber.setNumberIncompleter(true);
        genericNumber.setNumberingPlanIndicator(987654321);
        GenericNumberWrapper genericNumberWrapper = new TxGenericNumberWrapper(genericNumber);
        txAssistRequestInstructionsArgWrapper.setCorrelationID(genericNumberWrapper);

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {

        serializeToFile(txAssistRequestInstructionsArgWrapper);
        TxAssistRequestInstructionsArgWrapper tx = (TxAssistRequestInstructionsArgWrapper) deserializeFromFile();

        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getNatureOfAddressIndicator() == tx
                .getTxCorrelationID().getNatureOfAddressIndicator());
        assertEquals(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getAddress(),
                tx.getTxCorrelationID().getAddress());
        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getCode() == tx.getTxCorrelationID()
                .getCode());
        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getScreeningIndicator() == tx
                .getTxCorrelationID().getScreeningIndicator());

    }

}
