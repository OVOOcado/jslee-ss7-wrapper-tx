/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;


import org.mobicents.protocols.ss7.sccp.parameter.EncodingSchemeType;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle0001;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle0010;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle0011;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle0100;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper;

/**
 * TxGlobalTitleWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxGlobalTitleWrapper implements GlobalTitleWrapper {

	private final GlobalTitle globalTitle;

	public TxGlobalTitleWrapper(GlobalTitle globalTitle) {
		super();
		this.globalTitle = globalTitle;
	}	

	@Override
    public String getAddress(){
		if(this.globalTitle != null){
			return this.globalTitle.getDigits();
		}
		else{
			return null;
		}
	}
	
	@Override
    public NumberingPlan getNumberingPlan(){
		if(this.globalTitle != null){
			if(this.globalTitle instanceof GlobalTitle0011){
				return NumberingPlan.valueOf(((GlobalTitle0011)this.globalTitle).getNumberingPlan().getValue());
			}
			if(this.globalTitle instanceof GlobalTitle0100){
				return NumberingPlan.valueOf(((GlobalTitle0100)this.globalTitle).getNumberingPlan().getValue());
			}
		}
		return null;
	}
	
	@Override
    public Nature getNatureOfAddress(){
		if(this.globalTitle != null){
			if(this.globalTitle instanceof GlobalTitle0001){
				return Nature.valueOf(((GlobalTitle0001)this.globalTitle).getNatureOfAddress().getValue());
			}
			if(this.globalTitle instanceof GlobalTitle0100){
				return Nature.valueOf(((GlobalTitle0100)this.globalTitle).getNatureOfAddress().getValue());
			}
		}
		return null;
	}

	@Override
	public GlobalTitleIndicator getGlobalTitleIndicator() {
		if(this.globalTitle != null){
			return GlobalTitleIndicator.valueOf(this.globalTitle.getGlobalTitleIndicator().getValue());
		}
		return null;
	}

	@Override
	public Integer getTranslationType() {
		if(this.globalTitle != null){
			if(this.globalTitle instanceof GlobalTitle0011){
				return ((GlobalTitle0011)this.globalTitle).getTranslationType();
			}
			if(this.globalTitle instanceof GlobalTitle0100){
				return ((GlobalTitle0100)this.globalTitle).getTranslationType();
			}
			if(this.globalTitle instanceof GlobalTitle0010){
				return ((GlobalTitle0010)this.globalTitle).getTranslationType();
			}
		}
		return null;
	}

	@Override
	public EncodingScheme getEncodingScheme() {
		if(this.globalTitle != null){
			org.mobicents.protocols.ss7.sccp.parameter.EncodingScheme es = null;
			if(this.globalTitle instanceof GlobalTitle0011){
				es = ((GlobalTitle0011)this.globalTitle).getEncodingScheme();
			}
			if(this.globalTitle instanceof GlobalTitle0100){
				es = ((GlobalTitle0100)this.globalTitle).getEncodingScheme();
			}
			if(es != null){
				EncodingSchemeType type = es.getType();
				switch(type){
					case BCD_EVEN: return EncodingScheme.BCD_EVEN;
					case BCD_ODD: return EncodingScheme.BCD_ODD;
					case UNKNOWN:
					case NATIONAL_SPECIFIC: return null;
				}
			}
		}
		return null;
	}

	public GlobalTitle getTxGlobalTitle() {
		return globalTitle;
	}
	
	
}
