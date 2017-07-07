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

package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SSForBSCode;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSS_ForBS_CodeWrapper;

public class TxMAPSS_ForBS_CodeWrapperTest extends WrapperBaseTest {

    TxMAPSS_ForBS_CodeWrapper txMAPSS_ForBS_CodeWrapper;

    @Before
    public void setUp() throws Exception {

        TeleserviceCode teleserviceCode = mapParameterFactory
                .createTeleserviceCode(TeleserviceCodeValue.allPLMN_specificTS);
        BasicServiceCode basicServiceCode = mapParameterFactory.createBasicServiceCode(teleserviceCode);
        org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode ssCode = mapParameterFactory
                .createSSCode(SupplementaryCodeValue.allCallOfferingSS);
        SSForBSCode ssForBSCode = mapParameterFactory.createSSForBSCode(ssCode, basicServiceCode, true);
        txMAPSS_ForBS_CodeWrapper = new TxMAPSS_ForBS_CodeWrapper(ssForBSCode);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPSS_ForBS_CodeWrapper);
        TxMAPSS_ForBS_CodeWrapper tx = (TxMAPSS_ForBS_CodeWrapper) deserializeFromFile();

        assertTrue(txMAPSS_ForBS_CodeWrapper.getTxSSForBSCode().getBasicService().getTeleservice()
                .getTeleserviceCodeValue().getCode() == tx.getTxSSForBSCode().getBasicService().getTeleservice()
                        .getTeleserviceCodeValue().getCode());
        assertTrue(txMAPSS_ForBS_CodeWrapper.getTxSSForBSCode().getSsCode().getSupplementaryCodeValue().getCode() == tx
                .getTxSSForBSCode().getSsCode().getSupplementaryCodeValue().getCode());
    }

}
