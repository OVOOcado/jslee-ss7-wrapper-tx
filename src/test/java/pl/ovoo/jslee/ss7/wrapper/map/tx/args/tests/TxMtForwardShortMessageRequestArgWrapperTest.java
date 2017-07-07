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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpDaWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMtForwardShortMessageRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpOaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpUiWrapper;

public class TxMtForwardShortMessageRequestArgWrapperTest extends WrapperBaseTest {

    TxMtForwardShortMessageRequestArgWrapper txMtForwardShortMessageRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txMtForwardShortMessageRequestArgWrapper = new TxMtForwardShortMessageRequestArgWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260435678876987");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        TxSmRpDaWrapper txSmRpDaWrapper = new TxSmRpDaWrapper();
        txSmRpDaWrapper.setIMSI(txIMSIAddressWrapper);
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Da(txSmRpDaWrapper);

        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "0048657359345");
        ISDNAddressStringWrapper addressStringWrapper = new TxISDNAddressStringWrapperImpl(addressString);
        TxSmRpOaWrapper txSmRpOaWrapper = new TxSmRpOaWrapper();
        txSmRpOaWrapper.setServiceCentreAddressOa(addressStringWrapper);
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Oa(txSmRpOaWrapper);

        TxSmRpUiWrapper txSmRpUiWrapper = new TxSmRpUiWrapper();
        txSmRpUiWrapper.setCharset(DataCodingWrapper.GSM7);
        txSmRpUiWrapper.setText("text message");
        txSmRpUiWrapper.setIsConcatened(true);
        txSmRpUiWrapper.setMoreMessagesToSend(true);
        txSmRpUiWrapper.setMessageRef(1);
        txSmRpUiWrapper.setSegmCnt(2);
        txSmRpUiWrapper.setSegmNum(1);
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Ui(txSmRpUiWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txMtForwardShortMessageRequestArgWrapper);
        TxMtForwardShortMessageRequestArgWrapper tx = (TxMtForwardShortMessageRequestArgWrapper) deserializeFromFile();

        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Da().getIMSI().getAddress().equals(tx.getSm_Rp_Da().getIMSI().getAddress()));
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Oa().getServiceCentreAddressOA().getNature()
                .getValue() == tx.getSm_Rp_Oa().getServiceCentreAddressOA().getNature().getValue());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Oa().getServiceCentreAddressOA().getNumberingPlan()
                .getValue() == tx.getSm_Rp_Oa().getServiceCentreAddressOA().getNumberingPlan().getValue());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getMoreMessagesToSend());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getIsConcatened());
        assertEquals(1, txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getMessageRef());
        assertEquals(2, txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getSegmCnt());
        assertEquals(1, txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getSegmNum());
        String s1 = new String(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getText().getBytes(StandardCharsets.UTF_8),getCharsetFromGsmCoding(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getCharset().getValue()));
        String s2 = new String(tx.getSm_Rp_Ui().getText().getBytes(StandardCharsets.UTF_8),getCharsetFromGsmCoding(tx.getSm_Rp_Ui().getCharset().getValue()));


        assertTrue(s1.equals(s2));

    }

    public static Charset getCharsetFromGsmCoding(int value){
        switch(value){
            case 0:
            case 4:
                return StandardCharsets.UTF_8;
            case 8:
                return StandardCharsets.UTF_16BE;
            default:
                return null;
        }
    }
}
