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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;


import pl.ovoo.jslee.ss7.wrapper.map.args.ForwardShortMessageRequestWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpDaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpOaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper;


/**
 * Created by karolsimka on 08.06.17.
 */
public class TxForwardShortMessageRequestArgWrapper implements ForwardShortMessageRequestWrapper {

    /** The sm rp da wrapper. */
    private SmRpDaWrapper smRpDaWrapper;
    
    /** The sm rp oa wrapper. */
    private SmRpOaWrapper smRpOaWrapper;
    
    /** The sm rp ui wrapper. */
    private SmRpUiWrapper smRpUiWrapper;

    /**
     * Instantiates a new tx mt forward short message request arg wrapper.
     */
    public TxForwardShortMessageRequestArgWrapper() {
        super();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper#getSm_Rp_Da()
     */
    @Override
    public SmRpDaWrapper getSm_Rp_Da() {
        return this.smRpDaWrapper;
    }
    
    /**
     * Sets the sm_ rp_ da.
     *
     * @param sm_rp_da the new sm_ rp_ da
     */
    public void setSm_Rp_Da(SmRpDaWrapper sm_rp_da){
        this.smRpDaWrapper = sm_rp_da;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper#getSm_Rp_Ui()
     */
    @Override
    public SmRpUiWrapper getSm_Rp_Ui() {
        return this.smRpUiWrapper;
    }
    
    /**
     * Sets the sm_ rp_ ui.
     *
     * @param sm_rp_ui the new sm_ rp_ ui
     */
    public void setSm_Rp_Ui(SmRpUiWrapper sm_rp_ui){
        this.smRpUiWrapper = sm_rp_ui;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper#getSm_Rp_Oa()
     */
    @Override
    public SmRpOaWrapper getSm_Rp_Oa() {
        return this.smRpOaWrapper;
    }
    
    /**
     * Sets the sm_ rp_ oa.
     *
     * @param sm_rp_oa the new sm_ rp_ oa
     */
    public void setSm_Rp_Oa(SmRpOaWrapper sm_rp_oa){
        this.smRpOaWrapper = sm_rp_oa;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxForwardShortMessageRequestArgWrapper [Sm_Rp_Da=" + smRpDaWrapper + ", Sm_Rp_Oa="
                + smRpOaWrapper + ", Sm_Rp_Ui=" + smRpUiWrapper + "]";
    }

}
